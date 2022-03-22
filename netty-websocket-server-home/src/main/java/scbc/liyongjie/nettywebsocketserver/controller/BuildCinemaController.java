package scbc.liyongjie.nettywebsocketserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.nettywebsocketserver.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketserver.result.Result;
import scbc.liyongjie.nettywebsocketserver.service.BuildCinemaService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@RestController
public class BuildCinemaController {

    @Resource
    private BuildCinemaService buildCinemaService;

    //暂不做数据校验
    @GetMapping("/cinema/build/")
    public Result<String> buildCinema(@RequestBody BuildCinemaPoJo buildCinemaPoJo){
        String cinemaUUID = buildCinemaService.build(buildCinemaPoJo);
        return new Result<>(cinemaUUID);
    }

}
