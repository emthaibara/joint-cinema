package scbc.liyongjie.nettywebsocketservercinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.nettywebsocketservercinema.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketservercinema.result.Result;
import scbc.liyongjie.nettywebsocketservercinema.service.CinemaService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@RestController
public class CinemaController {

    @Resource
    private CinemaService cinemaService;

    @GetMapping("/get/cinema/init/data/")
    public Result<BuildCinemaPoJo> getCinemaInitData(@RequestParam(value = "cinemaUUID")String cinemaUUID){
        BuildCinemaPoJo buildCinemaPoJo = cinemaService.getCinemaInitData(cinemaUUID);
        return new Result<>(buildCinemaPoJo);
    }

    @GetMapping("/get/cinema/uuid/")
    public Result<String> getCinemaUUID(@RequestParam(value = "number")String number){
        String cinemaUUID = cinemaService.getCinemaUUID(number);
        return new Result<>(cinemaUUID);
    }

}
