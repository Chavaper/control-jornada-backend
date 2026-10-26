package cl.bennu.controljornadabackend.enums.handler;

import cl.bennu.commons.enums.base.BaseEnum;
import cl.bennu.commons.exception.NoDataException;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(BaseEnum.class)
public class EnumTypeHandler<T> extends cl.bennu.commons.enums.handler.EnumTypeHandler {

    public EnumTypeHandler(Class clazz) throws NoDataException {
        super(clazz);
    }

}