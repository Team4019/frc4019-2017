/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2016. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.cscore;

import java.util.function.Consumer;

/// An event listener.  This calls back to a desigated callback function when
/// an event matching the specified mask is generated by the library.
public class VideoListener {
  /// Create an event listener.
  /// @param listener Listener function
  /// @param eventMask Bitmask of VideoEvent.Type values
  /// @param immediateNotify Whether callback should be immediately called with
  ///        a representative set of events for the current library state.
  public VideoListener(Consumer<VideoEvent> listener, int eventMask,
                       boolean immediateNotify) {
    m_handle = CameraServerJNI.addListener(listener, eventMask, immediateNotify);
  }

  public synchronized void free() {
    if (m_handle != 0) {
      CameraServerJNI.removeListener(m_handle);
    }
    m_handle = 0;
  }

  public boolean isValid() {
    return m_handle != 0;
  }

  private int m_handle;
}
