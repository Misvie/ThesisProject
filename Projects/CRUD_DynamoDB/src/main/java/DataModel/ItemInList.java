package DataModel;

import DateUtil.DateFormatting;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDateTime;
import java.util.List;

@DynamoDBTable(tableName="ItemsInLists")
public class ItemInList {

	private String ID;

	private String listId;

	private String itemId;

	private LocalDateTime creationDate;

	private int measureVolume;

	private String measureUnit;

	private boolean available;

	private boolean suggestion;

	private List<String> imageUrls;

	private String name;

	/**
	 * The id will be of an ItemInList record.
	 */
	private String suggestionItemId;

	@DynamoDBHashKey(attributeName="ID")
	@DynamoDBAutoGeneratedKey
	public String getID() {
		return ID;
	}

	@DynamoDBAttribute(attributeName="ListId")
	public String getListId() {
		return listId;
	}

	@DynamoDBAttribute(attributeName="ItemId")
	public String getItemId() {
		return itemId;
	}

	@DynamoDBAttribute(attributeName="CreationDate")
	public String getCreationDate() {
		return DateFormatting.getFormattedDate(creationDate);
	}

	@DynamoDBAttribute(attributeName="MeasureVolume")
	public int getMeasureVolume() {
		return measureVolume;
	}

	@DynamoDBAttribute(attributeName="MeasureUnit")
	public String getMeasureUnit() {
		return measureUnit;
	}

	@DynamoDBAttribute(attributeName="Available")
	public boolean isAvailable() {
		return available;
	}

	@DynamoDBAttribute(attributeName="Suggestion")
	public boolean isSuggestion() {
		return suggestion;
	}

	@DynamoDBAttribute(attributeName="SuggestionItemId")
	public String getSuggestionId() {
		return suggestionItemId;
	}

	@DynamoDBAttribute(attributeName="ImageUrls")
	public List<String> getImageUrls()
	{
		return imageUrls;
	}

	//TODO : consider removing Item class
	@DynamoDBAttribute(attributeName = "Name")
	public String getName()
	{
		return name;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = DateFormatting.setToFormattedDate(creationDate);
	}

	public void setMeasureVolume(int measureVolume) {
		this.measureVolume = measureVolume;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setSuggestion(boolean suggestion) {
		this.suggestion = suggestion;
	}

	public void setSuggestionId(String suggestionId) {
		this.suggestionItemId = suggestionId;
	}

	public void setImageUrls(List<String> imageUrls)
	{
		this.imageUrls = null;
		this.imageUrls = imageUrls;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ItemInList(String listId, String itemId, int measureVolume, String measureUnit, boolean available, boolean suggestion, String suggestionItemId) {
		this.listId = listId;
		this.itemId = itemId;
		this.creationDate = LocalDateTime.now();
		this.measureVolume = measureVolume;
		this.measureUnit = measureUnit;
		this.available = available;
		this.suggestion = suggestion;
		this.suggestionItemId = suggestionItemId;
	}

	public ItemInList(){creationDate = LocalDateTime.now();}


}
