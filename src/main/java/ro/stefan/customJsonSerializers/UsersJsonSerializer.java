package ro.stefan.customJsonSerializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ro.stefan.model.Users;

import java.io.IOException;

public class UsersJsonSerializer extends JsonSerializer<Users> {

    @Override
    public void serialize(Users value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("id", value.getId().toString());
        gen.writeStringField("name", value.getName());
        gen.writeStringField("surname", value.getSurname());
        gen.writeStringField("username", value.getUsername());
        gen.writeStringField("email", value.getEmail());
        gen.writeStringField("enabled", value.getEnabled().toString());
        gen.writeStringField("accNonExp", value.getAccNonExp().toString());
        gen.writeStringField("accNonLocked", value.getAccNonLocked().toString());
        gen.writeStringField("credNonExpired", value.getCredNonExpired().toString());
        gen.writeStringField("role", value.getRole().getRole());
        gen.writeStringField("unit", value.getUnit().getUnit());

        gen.writeStringField("createdAt", null == value.getCreatedAt() ? null : value.getCreatedAt().toString());
        gen.writeStringField("createdBy", value.getCreatedBy());

        gen.writeStringField("modifiedAt", null == value.getModifiedAt() ? null :value.getModifiedAt().toString());
        gen.writeStringField("modifiedBy", value.getModifiedBy());

        gen.writeEndObject();
    }
}
