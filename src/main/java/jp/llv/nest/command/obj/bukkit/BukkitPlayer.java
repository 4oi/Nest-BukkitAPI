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

import java.util.Optional;
import jp.llv.nest.command.Type;
import jp.llv.nest.command.exceptions.TypeMismatchException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author toyblocks
 */
@Type("Player")
public class BukkitPlayer extends BukkitCommandSender<Player> {

    public BukkitPlayer(Player sender) {
        super(sender);
    }

    public BukkitPlayer(String name) throws TypeMismatchException {
        this(getPlayer(name));
    }

    @Override
    public <T> T to(Class<T> toClass) throws TypeMismatchException {
        return super.to(toClass, ifClass(BukkitLocation.class, () -> new BukkitLocation(super.value.getLocation())));
    }

    private static Player getPlayer(String name) throws TypeMismatchException {
        Player p = Bukkit.getPlayerExact(name);
        if (p == null) {
            throw new TypeMismatchException("Unknown player");
        }
        return p;
    }

    @Override
    public Optional<Location> getLocation() {
        return Optional.of(super.value.getLocation());
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
