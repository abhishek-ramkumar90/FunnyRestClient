package com.RestTemplate.constants;

public enum Status {
FAIL{
	@Override
	public String toString(){
		return "1";
	}
},SUCCESS{
	@Override
	public String toString(){
		return "0";
	}
}

}
