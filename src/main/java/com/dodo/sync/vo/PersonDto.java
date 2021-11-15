package com.dodo.sync.vo;

import com.dodo.sync.common.annotation.RelMapper;

@RelMapper
public class PersonDto {
    private Long id;
    @RelMapper(value="name")
    private String loginName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "PersonDto [id=" + id + ", loginName=" + loginName + "]";
    }

}
