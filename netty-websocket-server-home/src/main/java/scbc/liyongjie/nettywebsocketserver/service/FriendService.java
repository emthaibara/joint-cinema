package scbc.liyongjie.nettywebsocketserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.dao.FriendMapper;
import scbc.liyongjie.nettywebsocketserver.dao.UserMapper;
import scbc.liyongjie.nettywebsocketserver.exception.FriendNotExistException;
import scbc.liyongjie.nettywebsocketserver.exception.FriendRepeatException;
import scbc.liyongjie.nettywebsocketserver.po.Friend;
import scbc.liyongjie.nettywebsocketserver.po.User;
import scbc.liyongjie.nettywebsocketserver.pojo.FriendPoJo;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */

@Service
public class FriendService {

    private static final Logger log = LoggerFactory.getLogger(FriendService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private FriendMapper friendMapper;

    /**
     *  首先number---->all好友
     *  判断在线/离线
     * @param number    me
     * @return  返回在线好友列表哦
     */
    public List<FriendPoJo> getOnlineFriend(String number) {
        //all friends
        List<Friend> friends = friendMapper.selectByMe(number);
        return friendFilter(friends,Boolean.TRUE);
    }

    /**
     * 封装筛选好友状态的方法
     */
    private List<FriendPoJo> friendFilter(List<Friend> friends,Boolean isOnline){
        List<FriendPoJo> friendPoJoList = new ArrayList<>();
        //forEach循环遍历好友
        for (Friend friend : friends){
            if (isOnline){
                if (UserChannelMapUtil.isOnline(friend.getFriend())){
                    friendPoJoList.add(BuildFriendPoJo(friend.getFriend()));
                }
            }else{
                if (!UserChannelMapUtil.isOnline(friend.getFriend())){
                    friendPoJoList.add(BuildFriendPoJo(friend.getFriend()));
                }
            }
        }
        return friendPoJoList;
    }

    private FriendPoJo BuildFriendPoJo(String friendNumber){
        User friend = userMapper.selectByPrimaryKey(friendNumber);
        FriendPoJo friendPoJo = new FriendPoJo();
        friendPoJo.setFriendAvatar(friend.getAvatar());
        friendPoJo.setFriendName(friend.getName());
        friendPoJo.setFriendNumber(friendNumber);
        return friendPoJo;
    }

    public List<FriendPoJo> getOfflineFriend(String number) {
        //all friend
        List<Friend> friends = friendMapper.selectByMe(number);
        return friendFilter(friends,Boolean.FALSE);
    }

    public void delete(String me,String deleteFriend){
        if (friendMapper.selectByPrimaryKey(me,deleteFriend).isEmpty())
            throw new FriendNotExistException();
        friendMapper.deleteByPrimaryKey(me,deleteFriend);
        log.info("有对好友解除关系---me---{}---Friend---{}",me,deleteFriend);
    }

    public void add(String me,String addFriend){
        if (!friendMapper.selectByPrimaryKey(me, addFriend).isEmpty())
            throw new FriendRepeatException();
        Friend friend = new Friend();
        friend.setMe(me);
        friend.setFriend(addFriend);
        friendMapper.insert(friend);
        log.info("有对好友确立关系---me---{}---Friend---{}",me,addFriend);
    }


}
