package com.mvc.carshare.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CMarker {
    private int id;
    private double latitude;
    private double longitude;
    private double clatitude; //사이클 위도경도
    private double clongitude;  //사이클 위도경도
    private int car_number; //참조하는 카 번호

}
