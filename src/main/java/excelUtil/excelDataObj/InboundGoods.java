package excelUtil.excelDataObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fangiming on 2017/9/27.
 */
public class InboundGoods implements AutoTransformation{

    private String materielId;

    private String batchId;

    private String createTime;

    private String endTime;

    private String originalId;

    private Integer batchNum;

    private List<String> goodsId;

    private boolean hasTitleInbound;

    @Override
    public void autoTransformation(List<String> list) {
        this.materielId=list.get(0);
        this.batchId=list.get(1);
        this.createTime=list.get(2);
        this.endTime=list.get(3);
        this.originalId=list.get(4);
        this.batchNum= Integer.parseInt(list.get(5));
        setHasTitleInbound(list);
        if(this.hasTitleInbound)
            this.goodsId=new ArrayList<String>(Arrays.asList(list.get(6).split(",")));
    }


    public List<String> getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(List<String> goodsId) {
        this.goodsId = goodsId;
    }

    public String getMaterielId() {
        return materielId;
    }

    public void setMaterielId(String materielId) {
        this.materielId = materielId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    public boolean isHasTitleInbound() {
        return hasTitleInbound;
    }

    public void setHasTitleInbound(List<String> list) {
        hasTitleInbound=list.size()>6 && !list.get(6).trim().equals("");
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "InboundGoods{" +
                "materielId='" + materielId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", originalId='" + originalId + '\'' +
                ", batchNum=" + batchNum +
                ", goodsId=" + goodsId +
                ", hasTitleInbound=" + hasTitleInbound +
                '}';
    }
}
