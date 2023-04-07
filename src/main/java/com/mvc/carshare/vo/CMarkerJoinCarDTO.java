package com.mvc.carshare.vo;

import lombok.Data;


import java.sql.Timestamp;


@Data
public class CMarkerJoinCarDTO {
    private int id;
    private double latitude;
    private double longitude;
    private double clatitude; //사이클 위도경도
    private double clongitude;  //사이클 위도경도

    private int car_number;					//자동차ID
    ///////////////////////////////////////////////마커마커마커마커마커//////////////

    
    private String car_numberjoin;		//자동차번호
    private int car_id;		//자동차번호
    private int owner_id;			//소유주
    private int review_id;			//후기번호
    private String car_image;		//차량 이미지
    private String car_model;		//자동차 모델
    private String manufacturer;	//제조사
    private String engine_type;		//엔진종류
    private String car_type;		//자동차 타입
    private String c_year;          //차의 년식
    
    
    /////////////////////////////판매정보///////////////////////////////////////////////////
    private  int rid;
    private  int return_region_id;
    private int car_numberproduct;
    private int rent_price;
    private  int rent_time;
    private  Timestamp registered_at;
}
