package com.voximplant.reactnative;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.client.ClientState;
import com.voximplant.sdk.client.LoginError;
import com.voximplant.sdk.hardware.AudioDevice;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import static com.voximplant.reactnative.Constants.EVENT_MES_ACTION_GET_USER;
import static com.voximplant.reactnative.Constants.EVENT_MES_ACTION_GET_USERS;
import static com.voximplant.reactnative.Constants.EVENT_MES_ACTION_SET_STATUS;
import static com.voximplant.reactnative.Constants.EVENT_NAME_MES_GET_USER;
import static com.voximplant.reactnative.Constants.EVENT_NAME_MES_SET_STATUS;

class Utils {

    static List<String> createArrayList(ReadableArray readableArray) {
		if (readableArray == null) {
			return null;
		}
		List<String> list = new ArrayList<>(readableArray.size());
		for (int i = 0; i < readableArray.size(); i++) {
			ReadableType indexType = readableArray.getType(i);
			switch (indexType) {
			case String:
				list.add(readableArray.getString(i));
				break;
			default:
				throw new IllegalArgumentException("Could not convert object with index: " + i);
			}
		}
		return list;
	}

    static Map<String, String> createHashMap(ReadableMap v) {
        if (v == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        ReadableMapKeySetIterator it = v.keySetIterator();
        while (it.hasNextKey()) {
            String key = it.nextKey();
            map.put(key, v.getString(key));
        }
        return map;
    }

    static WritableMap createWritableMap(Map<String, String> v) {
        WritableMap map = Arguments.createMap();
        for (Map.Entry<String, String> entry : v.entrySet()) {
            map.putString(entry.getKey(), entry.getValue());
        }
        return map;
    }

	static String convertClientStateToString(ClientState state) {
		switch (state) {
			case DISCONNECTED:
				return Constants.DISCONNECTED;
			case CONNECTING:
				return Constants.CONNECTING;
			case CONNECTED:
				return Constants.CONNECTED;
			case LOGGING_IN:
				return Constants.LOGGING_IN;
			case LOGGED_IN:
				return Constants.LOGGED_IN;
			default:
				return Constants.DISCONNECTED;
		}
	}

	static int convertLoginErrorToInt(LoginError error) {
    	switch (error) {
			case INVALID_PASSWORD:
				return 401;
			case ACCOUNT_FROZEN:
				return 403;
			case INVALID_USERNAME:
				return 404;
			case TIMEOUT:
				return 408;
			case INVALID_STATE:
				return 491;
			case NETWORK_ISSUES:
				return 503;
			case TOKEN_EXPIRED:
				return 701;
			case INTERNAL_ERROR:
				default:
				return 500;
		}
	}

	static AudioDevice convertStringToAudioDevice(String device) {
		switch (device) {
			case Constants.BLUETOOTH:
				return AudioDevice.BLUETOOTH;
			case Constants.EARPIECE:
				return AudioDevice.EARPIECE;
			case Constants.SPEAKER:
				return AudioDevice.SPEAKER;
			case Constants.WIRED_HEADSET:
				return AudioDevice.WIRED_HEADSET;
			case Constants.NONE:
			default:
				return AudioDevice.NONE;
		}
	}

	static String convertAudioDeviceToString(AudioDevice device) {
		switch (device) {
			case BLUETOOTH:
				return Constants.BLUETOOTH;
			case EARPIECE:
				return Constants.EARPIECE;
			case SPEAKER:
				return Constants.SPEAKER;
			case WIRED_HEADSET:
				return Constants.WIRED_HEADSET;
			case NONE:
			default:
				return Constants.NONE;
		}
	}

	static int convertCameraTypeToCameraIndex(String cameraType) {
		return cameraType.equals(Constants.CAMERA_TYPE_BACK) ? 0 : 1;
	}

	static VideoCodec convertStringToVideoCodec(String videoCodec) {
		switch (videoCodec) {
			case "VP8":
				return VideoCodec.VP8;
			case "H264":
				return VideoCodec.H264;
			case "AUTO":
			default:
				return VideoCodec.AUTO;
		}
	}

	static String convertMessengerActionToString(MessengerAction action) {
    	switch (action) {
			case ADD_MODERATORS:
			case ADD_PARTICIPANTS:
			case CREATE_CONVERSATION:
			case EDIT_CONVERSATION:
			case EDIT_MESSAGE:
			case EDIT_PARTICIPANTS:
			case EDIT_USER:
			case GET_CONVERSATION:
			case GET_CONVERSATIONS:
				return "";
			case GET_USER:
				return EVENT_MES_ACTION_GET_USER;
			case GET_USERS:
				return EVENT_MES_ACTION_GET_USERS;
			case IS_DELIVERED:
			case IS_READ:
			case JOIN_CONVERSATION:
			case LEAVE_CONVERSATION:
			case MANAGE_NOTIFICATIONS:
			case REMOVE_CONVERSATION:
			case REMOVE_MESSAGE:
			case REMOVE_MODERATORS:
			case REMOVE_PARTICIPANTS:
			case RETRANSMIT_EVENTS:
			case SEND_MESSAGE:
				return "";
			case SET_STATUS:
				return EVENT_MES_ACTION_SET_STATUS;
			case SUBSCRIBE:
			case TYPING_MESSAGE:
			case UNSUBSCRIBE:
			case ACTION_UNKNOWN:
				default:
				return "";
		}
	}

	static String convertMessengerEventToString(MessengerEventType eventType) {
    	switch (eventType) {
			case IS_DELIVERED:
			case IS_READ:
			case ON_CREATE_CONVERSATION:
			case ON_EDIT_CONVERSATION:
			case ON_EDIT_MESSAGE:
			case ON_EDIT_USER:
			case ON_ERROR:
			case ON_GET_CONVERSATION:
				return "";
			case ON_GET_USER:
				return EVENT_NAME_MES_GET_USER;
			case ON_JOIN_CONVERSATION:
			case ON_LEAVE_CONVERSATION:
			case ON_REMOVE_CONVERSATION:
			case ON_REMOVE_MESSAGE:
			case ON_RETRANSMIT_EVENTS:
			case ON_SEND_MESSAGE:
				return "";
			case ON_SET_STATUS:
				return EVENT_NAME_MES_SET_STATUS;
			case ON_SUBSCRIBE:
			case ON_TYPING:
			case ON_UNSUBSCRIBE:
			case EVENT_UNKNOWN:
				default:
				return "";
		}
	}
}