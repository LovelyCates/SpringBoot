package edu.sakura.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
@ApiModel("排片实体类")
public class Plan {

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("排片时间")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date playtime;

    @ApiModelProperty("座位")
    private String seats;

    @ApiModelProperty("价格")
    private Float price;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("影厅ID")
    private Integer hall_id;

    @ApiModelProperty("电影ID")
    private Integer movie_id;
}
