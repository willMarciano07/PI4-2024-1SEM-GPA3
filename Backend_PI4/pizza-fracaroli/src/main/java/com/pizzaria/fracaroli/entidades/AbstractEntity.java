package com.pizzaria.fracaroli.entidades;

import java.io.Serializable;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	abstract Long getId();
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AbstractEntity && this.getId() != null && ((AbstractEntity) obj).getId() != null)
			return (this.getId() != null && this.getId().equals(((AbstractEntity) obj).getId())) 
					|| (((AbstractEntity) obj).getId() != null && ((AbstractEntity) obj).getId().equals(this.getId()));
		return super.equals(obj);
	}
	
}
