package scbc.liyongjie.nettywebsocketserverhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.nettywebsocketserverhome.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketserverhome.result.Result;
import scbc.liyongjie.nettywebsocketserverhome.service.BuildCinemaService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@RestController
public class BuildCinemaController {

    private static final Logger log = LoggerFactory.getLogger(BuildCinemaController.class);

    @Resource
    private BuildCinemaService buildCinemaService;

    @PostMapping("/cinema/build/")
    public Result<String> buildCinema(@RequestBody BuildCinemaPoJo buildCinemaPoJo){
        log.info("放映室-----[{}]",buildCinemaPoJo.toString());
        buildCinemaService.build(buildCinemaPoJo);
        return new Result<>("build cinema success!");
    }

}
