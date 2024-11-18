package com.example.manageruniversity.infra.media;

import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sys_media")
public class Media  extends SubBaseEntity {
    private String originalName;
    private String path;
}
