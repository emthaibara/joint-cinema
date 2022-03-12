package scbc.liyongjie.serviceffmpegapi.util;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/11
 *          简易版本---朴实无华
 *          ffmpeg -i originPath 2>&1 | grep 'Duration' | cut -d ' ' -f 4 | sed s/,//获取视频时长
 *          ffmpeg -i originPath -y -f mjpeg -ss 时长/2 -t 1  md5+thumbnail.jpeg  缩略图生成
 *          ffmpeg -i originPath -c copy -f dash targetPath     dash流生成
 */

public class BuildFFmpegCmd {
    public static String buildDASHCmd(String originPath,String targetPath){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ffmpeg -i ");
        stringBuffer.append(originPath);
        stringBuffer.append(" -c copy -f dash ");
        stringBuffer.append(targetPath);
        return stringBuffer.toString();
    }
    public static String buildThumbnailCmd(String originPath,String targetPath,Integer time){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ffmpeg -i ");
        stringBuffer.append(originPath);
        stringBuffer.append("-y -f mjpeg -ss ");
        stringBuffer.append(time);
        stringBuffer.append(" -t 1 ");
        stringBuffer.append(targetPath);
        return stringBuffer.toString();
    }

    public static String calculateDurationCmd(String originPath){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ffmpeg -i ");
        stringBuffer.append(originPath);
        stringBuffer.append(" 2>&1 | grep 'Duration' | cut -d ' ' -f 4 | sed s/,//");
        return stringBuffer.toString();
    }

}
/*

Muxer dash [DASH Muxer]:
    Common extensions: mpd.
    Default video codec: h264.
    Default audio codec: aac.
dash muxer AVOptions:
  -adaptation_sets   <string>     E........ Adaptation sets. Syntax: id=0,streams=0,1,2 id=1,streams=3,4 and so on
  -window_size       <int>        E........ number of segments kept in the manifest (from 0 to INT_MAX) (default 0)
  -extra_window_size <int>        E........ number of segments kept outside of the manifest before removing from disk (from 0 to INT_MAX) (default 5)
  -min_seg_duration  <int>        E........ minimum segment duration (in microseconds) (will be deprecated) (from 0 to INT_MAX) (default 5e+06)
  -seg_duration      <duration>   E........ segment duration (in seconds, fractional value can be set) (default 5)
  -remove_at_exit    <boolean>    E........ remove all segments when finished (default false)
  -use_template      <boolean>    E........ Use SegmentTemplate instead of SegmentList (default true)
  -use_timeline      <boolean>    E........ Use SegmentTimeline in SegmentTemplate (default true)
  -single_file       <boolean>    E........ Store all segments in one file, accessed using byte ranges (default false)
  -single_file_name  <string>     E........ DASH-templated name to be used for baseURL. Implies storing all segments in one file, accessed using byte ranges
  -init_seg_name     <string>     E........ DASH-templated name to used for the initialization segment (default "init-stream$RepresentationID$.m4s")
  -media_seg_name    <string>     E........ DASH-templated name to used for the media segments (default "chunk-stream$RepresentationID$-$Number%05d$.m4s")
  -utc_timing_url    <string>     E........ URL of the page that will return the UTC timestamp in ISO format
  -method            <string>     E........ set the HTTP method
  -http_user_agent   <string>     E........ override User-Agent field in HTTP header
  -http_persistent   <boolean>    E........ Use persistent HTTP connections (default false)
  -hls_playlist      <boolean>    E........ Generate HLS playlist files(master.m3u8, media_%d.m3u8) (default false)
  -streaming         <boolean>    E........ Enable/Disable streaming mode of output. Each frame will be moof fragment (default false)
  -timeout           <duration>   E........ set timeout for socket I/O operations (default -0.000001)
  -index_correction  <boolean>    E........ Enable/Disable segment index correction logic (default false)
  -format_options    <string>     E........ set list of options for the container format (mp4/webm) used for dash
  -dash_segment_type <int>        E........ set dash segment files type (from 0 to 1) (default mp4)
     mp4                          E........ make segment file in ISOBMFF format
     webm                         E........ make segment file in WebM format

 */