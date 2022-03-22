package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bookingdates {

    @Builder.Default
    public String checkin = "2015-11-12";
    @Builder.Default
    public String checkout = "2015-12-07";

}