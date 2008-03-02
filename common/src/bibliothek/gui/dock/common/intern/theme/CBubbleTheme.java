/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * CH - Switzerland
 */
package bibliothek.gui.dock.common.intern.theme;

import bibliothek.extension.gui.dock.theme.BubbleTheme;
import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.common.intern.color.BubbleTabTransmitter;
import bibliothek.gui.dock.themes.ColorProviderFactory;
import bibliothek.gui.dock.themes.color.TabColor;
import bibliothek.gui.dock.util.color.ColorManager;
import bibliothek.gui.dock.util.color.ColorProvider;

/**
 * A theme wrapping {@link BubbleTheme} and adding additional features to
 * properly work within the common-project.
 * @author Benjamin Sigg
 *
 */
public class CBubbleTheme extends CDockTheme<BubbleTheme>{
    /**
     * Creates a new theme
     * @param control the {@link CControl} for which this theme will be used.
     * @param theme the theme that gets encapsulated
     */
    public CBubbleTheme( final CControl control, BubbleTheme theme ) {
        super( theme );
        putColorProviderFactory( TabColor.class, new ColorProviderFactory<TabColor, ColorProvider<TabColor>>(){
            public ColorProvider<TabColor> create( ColorManager manager ) {
                BubbleTabTransmitter transmitter = new BubbleTabTransmitter( manager );
                transmitter.setControl( control );
                return transmitter;
            }
        });
    }
}
