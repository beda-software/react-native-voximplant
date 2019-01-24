/*
 * Copyright (c) 2011-2018, Zingaya, Inc. All rights reserved.
 */

'use strict';
/**
 * @memberOf Voximplant.Messaging
 * @type {{GetUser: string}}
 */
const MessengerEventTypes = {
    CreateConversation : 'CreateConversation',
    Delivered : 'Delivered',
    EditConversation: 'EditConversation',
    EditMessage: 'EditMessage',
    EditUser : 'EditUser',
    Error : 'Error',
    GetConversation : 'GetConversation',
    GetUser : 'GetUser',
    Read : 'Read',
    RemoveConversation : 'RemoveConversation',
    RemoveMessage : 'RemoveMessage',
    RetransmitEvents : 'RetransmitEvents',
    SendMessage : 'SendMessage',
    SetStatus : 'SetStatus',
    Subscribe : 'Subscribe',
    Typing : 'Typing',
    Unsubscribe : 'Unsubscribe'
};

export default MessengerEventTypes;