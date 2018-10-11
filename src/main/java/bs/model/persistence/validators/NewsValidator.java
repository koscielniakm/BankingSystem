package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;

import bs.model.config.Finals;
import bs.model.persistence.entities.NewsEntity;

public class NewsValidator extends AbstractValidator implements Validator<NewsEntity>{

	@Override
	public boolean validateBeforeCreate(NewsEntity entity) {
		return getValidationResult(getValidationsBeforeCreate(entity));
	}
	
	private List<Boolean> getValidationsBeforeCreate(NewsEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getTitle()));
		validationList.add(validateNotNull(entity.getContent()));
		validationList.add(validateNotNull(entity.getDate()));
		validationList.add(validateTitleLength(entity.getTitle()));
		return validationList;
	}

	@Override
	public boolean validateBeforeUpdate(NewsEntity entity) {
		return getValidationResult(getValidationsBeforeUpdate(entity));
	}
	
	private List<Boolean> getValidationsBeforeUpdate(NewsEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getId()));
		validationList.add(validateNotNull(entity.getTitle()));
		validationList.add(validateNotNull(entity.getContent()));
		validationList.add(validateNotNull(entity.getDate()));
		validationList.add(validateId(entity.getId()));
		validationList.add(validateTitleLength(entity.getTitle()));
		return validationList;
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		return validateId(id);
	}
	
	private boolean validateTitleLength(String title) {
		Integer maxLength = Finals.DB_NEWS_TITLE_MAX_LENGTH;
		return title.length() > maxLength ? false : true;
	}

}
