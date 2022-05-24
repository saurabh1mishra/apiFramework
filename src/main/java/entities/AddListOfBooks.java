package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AddListOfBooks {
    private String userId;
    private List<isbn> collectionOfIsbns;
}
