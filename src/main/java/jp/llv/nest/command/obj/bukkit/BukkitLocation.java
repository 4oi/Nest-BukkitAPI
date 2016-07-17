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
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author toyblocks
 */
@Type("BukkitLocation3d")
public class BukkitLocation extends NestValueAdapter<Location> implements Location3.Location3d<Location> {
    
    public BukkitLocation(Location e) {
        super(e);
    }

    public void setWorld(World world) {
        value.setWorld(world);
    }

    public World getWorld() {
        return value.getWorld();
    }

    public Block getBlock() {
        return value.getBlock();
    }

    public void setX(double x) {
        value.setX(x);
    }

    @Override
    public @NotNull Double getX() {
        return value.getX();
    }

    @Override
    public @NotNull Double getY() {
        return value.getY();
    }

    @Override
    public @NotNull Double getZ() {
        return value.getZ();
    }

    @Override
    public <T> T to(Class<T> toClass) throws TypeMismatchException {
        return super.to(toClass, ifClass(Location3.Location3i.class, () -> {
            return new BukkitBlockLocation(super.value);
        }));
    }
    
}
