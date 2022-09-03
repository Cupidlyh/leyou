package com.leyou.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long brandId;
    private Long cid1;// 1级类目
    private Long cid2;// 2级类目
    private Long cid3;// 3级类目
    private String title;// 标题
    private String subTitle; // 子标题
    private Boolean saleable;// 是否上架
    @JsonIgnore
    private Boolean valid; // 是否有效,逻辑删除用
    private Date createTime;// 创建时间
    @JsonIgnore
    private Date lastUpdateTime;// 最后修改时间


    // 上面是持久层的实体类的内容（pojo），上面和数据库表的字段相对应
    // 下面其实是业务层抽象出来的（vo），可以对应也可以不对应
    // 此项目为了简单所以将二者写到一起，实际开发应开分开写

    @Transient
    private String bname;

    @Transient
    private String cname;

    @Transient
    private List<Sku> skus;

    @Transient
    private SpuDetail spuDetail;

}
