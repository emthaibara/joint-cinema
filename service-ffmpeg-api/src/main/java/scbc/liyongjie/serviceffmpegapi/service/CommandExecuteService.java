package scbc.liyongjie.serviceffmpegapi.service;

import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.serviceffmpegapi.util.BuildFFmpegCmd;
import scbc.liyongjie.serviceffmpegapi.util.ChangeTimeFormatUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/14
 *
 */

@Service
public class CommandExecuteService {

    private static final Logger log = LoggerFactory.getLogger(CommandExecuteService.class);

    public void ffmpegBuildDASH(String originPath,String targetPath){
        ffmpegBuildDASHCommandExecute(BuildFFmpegCmd.buildDASHCmd(originPath,targetPath));
    }

    //异步执行就完事了
    public void ffmpegBuildThumbnail(String originPath,String targetPath){
        ffmpegBuildThumbnailCommandExecute(BuildFFmpegCmd.buildThumbnailCmd(originPath,targetPath));
    }

    public String ffmpegCalculateDuration(String originPath){
        return ChangeTimeFormatUtils.changeDuration(calculateDurationCommandExecute(BuildFFmpegCmd.buildCalculateDuration(originPath)));
    }

    private final DefaultExecutor buildDASHExec = new DefaultExecutor();

    private void ffmpegBuildDASHCommandExecute(String cmd){
        log.info("ffmpegBuildDASHCommandExecute invoke!");
        log.info("cmd---------[{}]-------ffmpeg exec loading .......",cmd);
        CommandLine commandLine = CommandLine.parse(cmd);
        try {
            buildDASHExec.execute(commandLine);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private final DefaultExecutor buildThumbnailExec = new DefaultExecutor();

    private void ffmpegBuildThumbnailCommandExecute(String cmd){
        log.info("ffmpegBuildThumbnailCommandExecute invoke!");
        log.info("cmd---------[{}]-------ffmpeg exec loading .......",cmd);
        CommandLine commandLine = CommandLine.parse(cmd);
        try {
            buildThumbnailExec.execute(commandLine);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private final DefaultExecutor calculateDurationExec = new DefaultExecutor();

    private synchronized String calculateDurationCommandExecute(String cmd){
        log.info("calculateDurationCommandExecute invoke!");
        log.info("cmd---------[{}]-------ffmpeg exec loading .......",cmd);
        CommandLine commandLine = CommandLine.parse(cmd);
        try {
            ByteArrayOutputStream susStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
            calculateDurationExec.setStreamHandler(streamHandler);
            calculateDurationExec.execute(commandLine);
            return susStream.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return "0小时0分钟0秒";
    }

}

