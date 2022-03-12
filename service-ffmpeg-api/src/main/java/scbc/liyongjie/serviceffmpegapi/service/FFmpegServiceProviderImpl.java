package scbc.liyongjie.serviceffmpegapi.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scbc.liyongjie.serviceffmpegapi.rpc.*;
import scbc.liyongjie.serviceffmpegapi.util.BuildFFmpegCmd;
import scbc.liyongjie.serviceffmpegapi.util.ResultUtils;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/11
 */
@GrpcService
public class FFmpegServiceProviderImpl extends FFmpegServiceGrpc.FFmpegServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(FFmpegServiceProviderImpl.class);

    /**
     *      生成dash流
     *      需提供视频源路径
     *      已经待生成dash流的文件夹
     * @param request       request {originPath,targetPath}
     * @param responseObserver  response
     */
    @Override
    public void ffmpegBuildDASHService(FFmpegBuildDASHServiceRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        String targetPath = request.getTargetPath();
        log.info("ffmpegBuildDASHService----有新来的Grpc调用------{}------{}",originPath,targetPath);
        ResultResponse.newBuilder().build();

        responseObserver.onNext(ResultUtils
                .getSuccessResultResponse(BuildFFmpegCmd.buildDASHCmd(originPath,targetPath)));
        responseObserver.onCompleted();
        log.info("ffmpegBuildDASHService  onCompleted");
    }

    /**
     *  生成缩略图
     *  首先需要计算视频时长，并传递至该服务
     * @param request   request {originPath,targetPath}
     * @param responseObserver  response
     */
    @Override
    public void ffmpegBuildThumbnailService(FFmpegBuildThumbnailServiceRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        String targetPath = request.getTargetPath();
        Integer time = request.getTime();       //单位秒
        log.info("ffmpegBuildThumbnailService----有新来的Grpc调用------{}------{}",originPath,targetPath);
        responseObserver.onNext(ResultUtils
                .getSuccessResultResponse(BuildFFmpegCmd.buildThumbnailCmd(originPath,targetPath,time)));
        responseObserver.onCompleted();
        log.info("ffmpegBuildThumbnailService  onCompleted");
    }

    /**
     *  计算视频时长-----返回结果为        01:38:18.83
     *  需要提供视频源的路径
     * @param request   request {originPath}
     * @param responseObserver  response    {result==second单位}
     */
    @Override
    public void ffmpegCalculateDuration(FFmpegCalculateDurationRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        log.info("ffmpegCalculateDuration----有新来的Grpc调用------{}}",originPath);
        responseObserver.onNext(ResultUtils.getSuccessResultResponse(BuildFFmpegCmd
                .calculateDurationCmd(originPath)));
        responseObserver.onCompleted();
        log.info("ffmpegCalculateDuration  onCompleted");
    }
}
