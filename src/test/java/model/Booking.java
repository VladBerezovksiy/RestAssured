package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @SerializedName("firstname")
    @Builder.Default
    public String firstname = "testes";
    @SerializedName("lastname")
    @Builder.Default
    public String lastname = "tester";
    @SerializedName("totalprice")
    @Builder.Default
    public int totalPrice = 101;
    @SerializedName("depositpaid")
    @Builder.Default
    public boolean depositPaid = true;
    @SerializedName("bookingdates")
    @Builder.Default
    public Bookingdates bookingdates = new Bookingdates();
    @SerializedName("additionalneeds")
    @Builder.Default
    public String additionalNeeds = "Message";
}
