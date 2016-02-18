
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class PrepareForLowBar extends CommandGroup {
	
    public PrepareForLowBar() {

        addParallel(new CollectorPositionDown());
        addParallel(new ManipulatorPositionDown());

    } 
}
