package com.hhk.suppermall.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
public class BucketPolicyConfig {
    private String Version;
    private List<Statement> Statement;
    @Data
    @Builder
    public static class Statement{
        private String Effect;
        private String Principal;
        private String Action;
        private String Resource;
    }
}
