/* 
 * The MIT License
 *
 * Copyright 2016 toyblocks.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
