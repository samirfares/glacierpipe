/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package glacierpipe.terminal;

import java.io.PrintWriter;

public class Util {
	
	public static void printTime(PrintWriter writer, long ms, boolean printAll) {
		
		long days = ms / (1000 * 60 * 60 * 24);
		ms = ms % (1000 * 60 * 60 * 24);
		long hours = ms / (1000 * 60 * 60);
		ms = ms % (1000 * 60 * 60);
		long minutes = ms / (1000 * 60);
		ms = ms % (1000 * 60);
		double seconds = ms / 1000.0;
		
		if (printAll || days > 0) {
			writer.printf("%03dd", days);
		}
		if (printAll || hours > 0) {
			writer.printf("%02dh", hours);
		}
		if (printAll || minutes > 0) {
			writer.printf("%02dm", minutes);
		}
		
		writer.printf("%05.2fs", seconds);
	}
	
	public static void printHex(PrintWriter writer, byte[] bytes) {
		for (byte b : bytes) {
			writer.printf("%02x", b);
		}
	}
	
	public static String toHumanReadableDataSize(long bytes) {
		if (bytes < (1L << 0L) * 128L) {
			return String.format("%d B", bytes);
		} else if (bytes < (1L << 10L) * 128L) {
			return String.format("%.3f KB", (double)bytes / (1L << 10L));
		} else if (bytes < (1L << 20L) * 128L) {
			return String.format("%.3f MB", (double)bytes / (1L << 20L));
		} else if (bytes < (1L << 30L) * 128L) {
			return String.format("%.3f GB", (double)bytes / (1L << 30L));
		} else if (bytes < (1L << 40L) * 128L) {
			return String.format("%.3f TB", (double)bytes / (1L << 40L));
		} else if (bytes < (1L << 50L) * 128L) {
			return String.format("%.3f PB", (double)bytes / (1L << 50L));
		} else {
			return String.format("%.3f EB", (double)bytes / (1L << 60L));
		}
	}
}
