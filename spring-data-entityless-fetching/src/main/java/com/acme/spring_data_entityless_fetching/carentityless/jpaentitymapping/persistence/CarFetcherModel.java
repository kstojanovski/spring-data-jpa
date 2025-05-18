package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarFetcherModel {

   @Id
   private Integer carId;
   private String carModel;
   private Integer carCreationYear;
   private String carBrand;

   public Integer getCarId() {
      return carId;
   }

   public void setCarId(Integer carId) {
      this.carId = carId;
   }

   public String getCarModel() {
      return carModel;
   }

   public void setCarModel(String carModel) {
      this.carModel = carModel;
   }

   public Integer getCarCreationYear() {
      return carCreationYear;
   }

   public void setCarCreationYear(Integer carCreationYear) {
      this.carCreationYear = carCreationYear;
   }

   public String getCarBrand() {
      return carBrand;
   }

   public void setCarBrand(String carBrand) {
      this.carBrand = carBrand;
   }
}
