package com.example.kaka.myweather.bean;

import java.util.List;

public class WeatherBean {
    private List<HeWeather> HeWeather;
    public class HeWeather{
        private Basic basic;
        private Update update;
        private String status;
        private Now now;
        private List<Daily_forecast> daily_forecast;
        private Aqi aqi;
        private Suggestion suggestion;
        private String msg;

        public class Basic {
            private String cid;     //"CN101190401"
            private String location;    //"苏州"
            private String parent_city	;   //"苏州"
            private String admin_area;  //"江苏"
            private String cnty;    //"中国"
            private String lat;     //"38.91458893"
            private String lon;     //"121.61862183"
            private String tz;      //"+8.00"
            private String city;	//"苏州"
            private String id;      //"CN101190401"
            private Update update;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Update getUpdate() {
                return update;
            }

            public void setUpdate(Update update) {
                this.update = update;
            }
        }

        public class Update {
            private String loc;     //"2019-04-07 17:02"
            private String utc;     //"2019-04-07 09:02"

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public class Now {
            private String cloud;   //"10"
            private String cond_code;   //"100"
            private String cond_txt;    //"晴"
            private String fl;      //"3"
            private String hum;     //"28"
            private String pcpn;    //"0.0"
            private String pres;    //"1014"
            private String tmp;     //"6"
            private String vis;     //"16"
            private String wind_deg;    //"183"
            private String wind_dir;    //"南风"
            private String wind_sc;     //"2"
            private String wind_spd;    //"8"
            private Cond cond;

            public class Cond {
                private String code;    //	"100"
                private String txt;     //	"晴"

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }

            public Cond getCond() {
                return cond;
            }

            public void setCond(Cond cond) {
                this.cond = cond;
            }
        }

        public class Daily_forecast {
            private String date;
            private Cond cond;
            private Tmp tmp;

            public class Cond {
                private String txt_d;

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }
            }

            public class Tmp {
                private String max;     //	"9"
                private String min;     //	"2"

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public Cond getCond() {
                return cond;
            }

            public void setCond(Cond cond) {
                this.cond = cond;
            }

            public Tmp getTmp() {
                return tmp;
            }

            public void setTmp(Tmp tmp) {
                this.tmp = tmp;
            }
        }

        public class Aqi {
            private City city;

            public class City {
                private String aqi;     //	"36"
                private String pm25;    // "18"
                private String qlty;    //	"优"

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }
            }

            public City getCity() {
                return city;
            }

            public void setCity(City city) {
                this.city = city;
            }
        }

        public class Suggestion {
            private Comf comf;
            private Sport sport;
            private Cw cw;

            public class Comf {
                private String type;    //	"comf"
                private String brf;     //	"较舒适"
                private String txt;     //	"白天有雨，风力较强，这种天气条件下，人们会感到有些凉意，但大部分人完全可以接受。"

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public class Sport {
                private String type;    //	"sport"
                private String brf;     //	"较不宜"
                private String txt;     //	"有降水，且风力较强，推荐您在室内进行各种健身休闲运动；若坚持户外运动，请注意防风保暖。"

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public class Cw {
                private String type;    //"cw"
                private String brf;     //	"不宜"
                private String txt;     //	"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public Comf getComf() {
                return comf;
            }

            public void setComf(Comf comf) {
                this.comf = comf;
            }

            public Sport getSport() {
                return sport;
            }

            public void setSport(Sport sport) {
                this.sport = sport;
            }

            public Cw getCw() {
                return cw;
            }

            public void setCw(Cw cw) {
                this.cw = cw;
            }
        }

        public Basic getBasic() {
            return basic;
        }

        public void setBasic(Basic basic) {
            this.basic = basic;
        }

        public Update getUpdate() {
            return update;
        }

        public void setUpdate(Update update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Now getNow() {
            return now;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public List<Daily_forecast> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<Daily_forecast> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public Aqi getAqi() {
            return aqi;
        }

        public void setAqi(Aqi aqi) {
            this.aqi = aqi;
        }

        public Suggestion getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Suggestion suggestion) {
            this.suggestion = suggestion;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public List<WeatherBean.HeWeather> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<WeatherBean.HeWeather> heWeather) {
        HeWeather = heWeather;
    }
}
