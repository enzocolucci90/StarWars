package com.example.corso.starwarsinfo.data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "next",
        "previous",
        "results"
})

public class People {

        @JsonProperty("count")
        private int count;
        @JsonProperty("next")
        private String next;
        @JsonProperty("previous")
        private Object previous;
        @JsonProperty("results")
        private List<Person> person = null;

        @JsonProperty("count")
        public int getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(int count) {
            this.count = count;
        }

        @JsonProperty("next")
        public String getNext() {
            return next;
        }

        @JsonProperty("next")
        public void setNext(String next) {
            this.next = next;
        }

        @JsonProperty("previous")
        public Object getPrevious() {
            return previous;
        }

        @JsonProperty("previous")
        public void setPrevious(Object previous) {
            this.previous = previous;
        }

        @JsonProperty("results")
        public List<Person> getPerson() {
            return person;
        }

        @JsonProperty("results")
        public void setPerson(List<Person> results) {
            this.person = results;
        }


}
