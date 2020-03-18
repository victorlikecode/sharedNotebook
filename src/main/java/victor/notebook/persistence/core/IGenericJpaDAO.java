package victor.notebook.persistence.core;

import java.io.Serializable;
import java.util.List;

public interface IGenericJpaDAO<T,ID extends Serializable> {

	public T create(T t);
	
	public T read(ID id);
	
	public List<T> readAll();
	
	public T update(T t);
	
	public void delete(T t);
	
	public void flush();
	
	public void refresh(T t);
}
