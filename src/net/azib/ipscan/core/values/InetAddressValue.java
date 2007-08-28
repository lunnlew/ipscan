/**
 * This file is a part of Angry IP Scanner source code,
 * see http://www.azib.net/ for more information.
 * Licensed under GPLv2.
 */

package net.azib.ipscan.core.values;

import java.net.InetAddress;

/**
 * InetAddressValue - a comparable holder of IP addresses
 *
 * @author Anton Keks
 */
public class InetAddressValue implements Comparable<InetAddressValue> {
	
	private String s;
	private byte[] a;

	public InetAddressValue(InetAddress address) {
		s = address.getHostAddress();
		a = address.getAddress();
	}

	public int compareTo(InetAddressValue that) {
		byte[] b1 = this.a;
		byte[] b2 = that.a;
		
		// compare each byte
		for (int i = 0; i < b1.length; i++) {
			if (b1[i] == b2[i])
				continue;
			else
			if ((b1[i]&0xFF) > (b2[i]&0xFF))
				return 1;
			else
				return -1;
		}
		// all bytes are equal
		return 0;
	}
	
	@Override
	public String toString() {
		return s;
	}

	@Override
	public int hashCode() {
		return s.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final InetAddressValue other = (InetAddressValue) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		}
		else if (!s.equals(other.s))
			return false;
		return true;
	}
}
