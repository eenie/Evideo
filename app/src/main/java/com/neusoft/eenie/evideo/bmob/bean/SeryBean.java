package com.neusoft.eenie.evideo.bmob.bean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Eenie on 2015/12/3.
 *
 */
public class SeryBean extends BmobObject {

    private String title = "闪电侠 第二季";
    private String state = "更新至第8集";
    private List<String> seriesUrl = new ArrayList<>();
    private BmobFile indexPic = null;
    private BmobFile thumbnail = null;

    private String intro="英文全名The Flash，第2季(2015)CW. 本季看点：《闪电侠》的制片人表示，第一季结尾留下的悬念将在第二季开始后很快解开，Caitlin和Cisco的命运将在第二季或者第三季揭晓。此外，这个初代闪电侠Jay Garrick的头盔证实该剧今后会往多维宇宙的方向发展（Jay Garrick来自「Earth-Two」）。凑巧的是，Cisco是漫画英雄「Vibe」，而「Vibe」具有探测跨维度时空漏洞的超能力。《The Flash》第一季季终集达到了387万收视人数。第二季预计10月6日在CW回归播出，敬请期待。";

    public BmobFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(BmobFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getSeriesUrl() {
        return seriesUrl;
    }

    public void setSeriesUrl(List<String> seriesUrl) {
        this.seriesUrl = seriesUrl;
    }

    public BmobFile getIndexPic() {
        return indexPic;
    }

    public void setIndexPic(BmobFile indexPic) {
        this.indexPic = indexPic;
    }
}
