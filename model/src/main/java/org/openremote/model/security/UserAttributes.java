package org.openremote.model.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Wrapper class for user attributes
public class UserAttributes {

    private List<UserAttribute> attributes;

    public UserAttributes() {
        this.attributes = new ArrayList<>();
    }

    public UserAttributes(List<UserAttribute> attributes) {
        this.attributes = attributes == null ? new ArrayList<>() : attributes;
    }

    public List<UserAttribute> getAttributes() {
        return attributes;
    }

    public Map<String, List<String>> getAttributeMap(){
        return attributes.stream().collect(Collectors.groupingBy(UserAttribute::getName, Collectors.mapping(UserAttribute::getValue, Collectors.toList())));
    }

    public boolean hasAttribute(String key){
        return attributes.stream().anyMatch(attr -> attr.getName().equals(key));
    }

    public void add(UserAttribute attribute) {
        if (attribute != null) {
            attributes.add(attribute);
        }
    }

    public void removeIf(String key){
        attributes.removeIf(attr -> attr.getName().equals(key));
    }

}
