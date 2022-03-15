package scbc.liyongjie.serviceffmpegapi.service;

import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import scbc.liyongjie.serviceffmpegapi.util.BuildFFmpegCmd;

import java.io.IOException;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/14
 */
@Service
@EnableAsync
public class CommandExecuteService {

    private static final Logger log = LoggerFactory.getLogger(CommandExecuteService.class);

    //异步执行就完事了
    @Async
    public void ffmpegBuildDASH(String originPath,String targetPath){
        log.info("origin--{}---targetPath---{}",originPath,targetPath);
        commandExecute(BuildFFmpegCmd.buildDASHCmd(originPath,targetPath));
    }

    @Async
    //异步执行就完事了
    public void ffmpegBuildThumbnail(String originPath,String targetPath){
        commandExecute(BuildFFmpegCmd.buildThumbnailCmd(originPath,targetPath));
    }

    private final DefaultExecutor exec = new DaemonExecutor();

    private void commandExecute(String cmd){
        CommandLine commandLine = CommandLine.parse(cmd);
        try {
            exec.execute(commandLine);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
