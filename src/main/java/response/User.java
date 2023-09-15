package response;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @EqualsAndHashCode.Exclude
    private int id = 0;

    private String name;
    private String gender;
    private String status;
    private String email;

}
