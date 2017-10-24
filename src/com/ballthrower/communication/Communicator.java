package com.ballthrower.communication;

import com.ballthrower.communication.packets.Packet;

public abstract class Communicator
{
	public abstract void awaitConnection();
	public abstract void closeConnection();

	public abstract Packet receivePacket();
	public abstract void sendPacket(Packet packet);
}
