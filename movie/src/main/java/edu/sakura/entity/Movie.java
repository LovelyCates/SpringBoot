package edu.sakura.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("电影实体类")
public class Movie {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("电影名")
    private String name;

    @ApiModelProperty("文件")
    private String img;

    @ApiModelProperty("电影描述信息")
    private String description;

    @ApiModelProperty("导演")
    private String director;

    @ApiModelProperty("编剧")
    private String writer;

    @ApiModelProperty("演员")
    private String actor;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("语言")
    private String language;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("上映时间")
    private Date showtime;

    @ApiModelProperty("影片时长")
    private String length;

    @ApiModelProperty("评分")
    private float grade;

    @ApiModelProperty("状态")  // 0 上映  1 下架
    private Integer status;

    @ApiModelProperty("IMDb链接")
    private String link;
}
