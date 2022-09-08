package fiveman.hotelservice.utils;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Common {
    public static final int PAGE_SIZE = 5; //default size of the product
    public static final int PAGE_INDEX = 0; //default page index
    
    public static final String OVERVIEW_TITLE = "Hotel Service";
    public static final String OVERVIEW_IMAGE_URL = "Not Found Image";
    public static final String OVERVIEW_DESCRIPTION = "No Description";

    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";

}
