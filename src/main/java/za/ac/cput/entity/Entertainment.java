package za.ac.cput.entity;

public class Entertainment {

        private int eventCode;
        private String ChooseEvent, about, date, time, location, cost,security;

        protected Entertainment() {}
        public Entertainment(za.ac.cput.entity.Entertainment.Builder builder) {
            this.eventCode = builder.eventCode;
            this.ChooseEvent = builder.ChooseEvent;
            this.about = builder.about;
            this.date = builder.date;
            this.time = builder.time;
            this.location = builder.location;
            this.cost = builder.cost;
            this.security = builder.security;
        }



        //getters
        public int getEventCode(){return  eventCode;}
        public String getChooseEvent() {
            return ChooseEvent;
        }
        public String getAbout() {
            return about;
        }
        public String getDate() {return date;}
        public String getTime() {
            return time;
        }
        public String getLocation() {
            return location;
        }
        public String getCost() {
            return cost;
        }
        public String getSecurity()
        {
            return security;
        }

        //setters

        public void setEventCode(int eventCode) {this.eventCode = eventCode;}
        public void setChooseEvent(String ChooseEvent) {
            this.ChooseEvent = ChooseEvent;
        }
        public void setAbout(String about) {
            this.about = about;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public void setCost(String cost) {
            this.cost = cost;
        }
        public void setSecurity(String security) {this.security = security;}

        @Override
        public String toString() {
            return "Entertainment{" +
                    "Event=" + eventCode +
                    "Choose Event=" + ChooseEvent +
                    ", About='" + about + '\'' +
                    ", Date='" + date + '\'' +
                    ", Time='" + time + '\'' +
                    ", Location='" + location + '\'' +
                    ", Cost='" + cost + '\'' +
                    ", Security='" + security + '\'' +
                    '}';
        }

        public static class Builder {
            //attributes
            private int eventCode;
            private String ChooseEvent, about, date, time, location, cost,security;

            //setters for builder pattern
            public za.ac.cput.entity.Entertainment.Builder setEventCode(int eventCode){
                this.eventCode = eventCode;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setChooseEvent(String chooseEvent) {
                this.ChooseEvent = chooseEvent;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setAbout(String about) {
                this.about = about;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setDate(String date) {
                this.date = date;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setTime(String time) {
                this.time = time;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setLocation(String location) {
                this.location = location;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setCost(String cost) {
                this.cost = cost;
                return this;
            }

            public za.ac.cput.entity.Entertainment.Builder setSecurity(String security){
                this.security = security;
                return  this;
            }

            public za.ac.cput.entity.Entertainment build()
            {
                return new za.ac.cput.entity.Entertainment(this);
            }

            public za.ac.cput.entity.Entertainment.Builder copy(Builder entertainment)
            {
                this.eventCode = entertainment.eventCode;
                this.ChooseEvent = entertainment.ChooseEvent;
                this.about = entertainment.about;
                this.date = entertainment.date;
                this.time = entertainment.time;
                this.location = entertainment.location;
                this.cost = entertainment.cost;
                this.security = entertainment.security;

                return this;
            }
        }
}
