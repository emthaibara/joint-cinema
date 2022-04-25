package scbc.liyongjie.nettywebsocketserverhome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserverhome.dao.FriendMapper;
import scbc.liyongjie.nettywebsocketserverhome.dao.UserMapper;
import scbc.liyongjie.nettywebsocketserverhome.exception.FriendNotExistException;
import scbc.liyongjie.nettywebsocketserverhome.exception.FriendRepeatException;
import scbc.liyongjie.nettywebsocketserverhome.po.Friend;
import scbc.liyongjie.nettywebsocketserverhome.po.User;
import scbc.liyongjie.nettywebsocketserverhome.pojo.FriendPoJo;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        log.info("user---{}-----all friend---{}",number, Arrays.toString(friends.toArray()));
        return friendFilter(friends,Boolean.TRUE);
    }

    /**
     * 封装筛选好友状态的方法
     */
    private List<FriendPoJo> friendFilter(List<Friend> friends, Boolean isOnline){
        List<FriendPoJo> friendPoJoList = new ArrayList<>();
        //forEach循环遍历好友
        for (Friend friend : friends){
            if (isOnline){
                log.info("-----正在筛选在线好友....");
                if (UserChannelMapUtil.isOnline(friend.getFriend())){
                    friendPoJoList.add(BuildFriendPoJo(friend.getFriend()));
                }
            }else{
                log.info("-----正在筛选离线好友....");
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
        log.info("user---{}-----all friend---{}",number, Arrays.toString(friends.toArray()));
        return friendFilter(friends,Boolean.FALSE);
    }

    public void delete(String me,String deleteFriend){
        if (friendMapper.selectByPrimaryKey(me,deleteFriend).isEmpty())
            throw new FriendNotExistException();
        friendMapper.deleteByPrimaryKey(me,deleteFriend);
        log.info("有对好友解除关系---me---{}---Friend---{}",me,deleteFriend);
    }

    public void add(String me,String addFriend){
        if (Objects.isNull(userMapper.selectByPrimaryKey(addFriend)))
            throw new FriendNotExistException();
        if (!friendMapper.selectByPrimaryKey(me, addFriend).isEmpty())
            throw new FriendRepeatException();
        Friend friend1 = new Friend();
        friend1.setMe(me);
        friend1.setFriend(addFriend);

        Friend friend2 = new Friend();
        friend2.setMe(addFriend);
        friend2.setFriend(me);

        friendMapper.insert(friend1);
        friendMapper.insert(friend2);
        log.info("有对好友确立关系---me---{}---Friend---{}",me,addFriend);
    }

}
