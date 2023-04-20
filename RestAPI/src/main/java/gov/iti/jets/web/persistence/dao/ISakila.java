package gov.iti.jets.web.persistence.dao;

import java.util.List;

public interface ISakila{
    public <T> T add(T object);
    public <T> List<T> getAll(String namedQuery);
    public <T> T getById(Class className, int id);
    public <T,TP> List<T> getBy(String namedQuery, String paramName, TP value);
    public <T> boolean update(T newObject);
    public <T> boolean deleteById(int id, Class className);
}
