package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingPartialData {

    @Builder.Default
    public String firstname = "Vlad";
    @Builder.Default
    public String lastname = "Berezovksiy";
}
