/*
 * Copyright (C) 2016 toyblocks
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.llv.nest.command.obj.bukkit;

import jp.llv.nest.command.Type;
import jp.llv.nest.command.exceptions.TypeMismatchException;
import jp.llv.nest.command.obj.Location3;
import jp.llv.nest.command.obj.NestValueAdapter;
import org.bukkit.Location;

/**
 *
 * @author toyblocks
 */
@Type("BukkitLocation3i")
public class BukkitBlockLocation extends NestValueAdapter<Location> implements Location3.Location3i<Location> {

    public BukkitBlockLocation(Location value) {
        super(value);
    }

    @Override
    public Long getX() {
        return (long) super.value.getBlockX();
    }

    @Override
    public Long getY() {
        return (long) super.value.getBlockY();
    }

    @Override
    public Long getZ() {
        return (long) super.value.getBlockZ();
    }

    @Override
    public <T> T to(Class<T> toClass) throws TypeMismatchException {
        return super.to(toClass, ifClass(Location3.Location3d.class, () -> {
            return new BukkitLocation(super.value);
        }));
    }
    
}
