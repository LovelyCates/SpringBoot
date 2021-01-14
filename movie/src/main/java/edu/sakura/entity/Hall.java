package edu.sakura.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("影厅实体类")
public class Hall {

    @JsonIgnore
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("影厅名")
    private String name;

    @ApiModelProperty("影厅座位")
    private String seats;

    @ApiModelProperty("影厅状态")
    private Integer status;
}
