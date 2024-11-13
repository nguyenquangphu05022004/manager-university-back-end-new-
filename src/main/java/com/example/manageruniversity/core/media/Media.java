package com.example.manageruniversity.core.media;

import com.example.manageruniversity.share.SubBaseEntity;
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
