package com.synex.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hotel_rooms")
public class HotelRoom {
	@Id
	private int hotelRoomId;
	@ManyToOne
	private RoomType type;
	@ManyToMany
	private Set<Amenities> amenities;
	private int noRooms;
	private float price;
	private float discount;
	private String description;
	private String policies;
	
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}		
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public Set<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(Set<Amenities> amenities) {
        this.amenities = amenities;
    }
    public void setHotelRoomAmenities(Set<Amenities> hotelRoomAmenities) {
		this.amenities = hotelRoomAmenities;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPolicies() {
		return policies;
	}
	public void setPolicies(String policies) {
		this.policies = policies;
	}
}
