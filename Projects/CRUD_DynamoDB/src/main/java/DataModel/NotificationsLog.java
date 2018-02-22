package DataModel;

import DateUtil.DateFormatting;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDateTime;

@DynamoDBTable(tableName="NotificationLogs")
public class NotificationsLog {

	private String ID;

	private String listId;

	private String notifyToUserId;

	private LocalDateTime notificationDate;

	private LocalDateTime creationDate;

	private String notificationMessege;

	/**
	 * failed, pending, success, etc
	 */
	private String notificationStatus;

	@DynamoDBHashKey(attributeName="ID")
	@DynamoDBAutoGeneratedKey
	public String getID() {
		return ID;
	}

	@DynamoDBAttribute(attributeName = "ListId")
	public String getListId() {
		return listId;
	}

	@DynamoDBAttribute(attributeName = "NotifyToUserId")
	public String getNotifyToUserId() {
		return notifyToUserId;
	}

	@DynamoDBAttribute(attributeName = "NotificationDate")
	public String getNotificationDate() {
		return DateFormatting.getFormattedDate(notificationDate);
	}

	@DynamoDBAttribute(attributeName = "CreationDate")
	public String getCreationDate() {
		return DateFormatting.getFormattedDate(creationDate);
	}

	@DynamoDBAttribute(attributeName = "NotificationMessege")
	public String getNotificationMessege() {
		return notificationMessege;
	}

	@DynamoDBAttribute(attributeName = "NotificationStatus")
	public String getNotificationStatus() {
		return notificationStatus;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public void setNotifyToUserId(String notifyToUserId) {
		this.notifyToUserId = notifyToUserId;
	}

	public void setNotificationDate(String notificationDate) {
		this.notificationDate = DateFormatting.setToFormattedDate(notificationDate);
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = DateFormatting.setToFormattedDate(creationDate);
	}

	public void setNotificationMessege(String notificationMessege) {
		this.notificationMessege = notificationMessege;
	}

	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public NotificationsLog(String listId, String notifyToUserId, LocalDateTime notificationDate, String notificationMessege, String notificationStatus) {
		this.listId = listId;
		this.notifyToUserId = notifyToUserId;
		this.notificationDate = notificationDate;
		this.creationDate = LocalDateTime.now();
		this.notificationMessege = notificationMessege;
		this.notificationStatus = notificationStatus;
	}

	public NotificationsLog(){creationDate = LocalDateTime.now();}
}