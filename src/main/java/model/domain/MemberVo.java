package model.domain;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {
    private String memberId;
    private String passwd;
    private String name;
    private String phone;
    private String uuid;
}
